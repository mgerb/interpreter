//Mitchell Gerber Java Fortran 77 interpreter CS 415

package interpreter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class main {
	
	//method to advance to the end of the line if it is finished reading the line
	public static void endOfLine(StringTokenizer stk)
	{
		while (stk.hasMoreTokens())
		{
			stk.nextToken();
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//new array list for new variables
		ArrayList vars = new ArrayList();
		String temp;
		
		// Open the file for use
		FileInputStream fstream = new FileInputStream("C:/g77/bin/FORTRANZ.for");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("interpreted.java")));
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		//create string for new line
		String line;
		
		
		
		//Read File Line By Line
		while ((line = br.readLine()) != null)   {
			
			String outputString = "";
			
			//convert the line to string tokenizer
			StringTokenizer stk = new StringTokenizer(line);
			
			
			//parses through each token in the line
			while (stk.hasMoreTokens())
			{
				//sets equal to next string
				String nextToken = stk.nextToken();
				
				//checks if end of main program
				if (nextToken.equals("end"))
				{
					outputString = " }";
					
					endOfLine(stk);
				}
				
				//beginning of program
				else if (nextToken.equals("program"))
				{
					outputString = "public class " + stk.nextToken() + " {\n\n	public static void main(String[] args) {\n";
					
					endOfLine(stk);
				}
				
				
				
				//call subroutines
				else if (nextToken.equals("call"))
				{
					outputString = stk.nextToken() + "();";
					
				}
				
				//create subroutines
				else if (nextToken.equals("subroutine"))
				{
					outputString = "public static void " + stk.nextToken() + "() {";
					
				}
				
				//declare integer values
				else if (nextToken.equals("integer"))
				{
					
					temp = stk.nextToken();
					
					//if integer is followed by ::
					if (!temp.equals("::"))
					{
						outputString = "int";
						
						outputString += " " + temp + ";";
						
						vars.add(temp);
					}
					
					
					else
					{
						temp = stk.nextToken();
						
						//if it is an array
						if (temp.length() > 1)
						{
							outputString += "int[][] " + temp.substring(0, 1) + " = new int";
							
							temp = temp.replace("(", "[");
							temp = temp.replace(",", "+1][");
							temp = temp.replace(")", "+1]");
							
							outputString += temp.substring(1) + ";";
							vars.add(temp.substring(0, 1));
						}
						
						//not an array
						else
						{
							outputString = "int";
							outputString += " " + temp + " " + stk.nextToken() + " " + stk.nextToken() + ";";
							vars.add(temp);
						}
						
						
					}
					
					
					
				}
				
				//changing variables
				else if(vars.contains(nextToken.substring(0,1)) && !nextToken.equals("if"))
				{
					nextToken = nextToken.replace("(", "[");
					nextToken = nextToken.replace(",", "][");
					nextToken = nextToken.replace(")", "]");
					
					outputString += nextToken + " ";
					
					while(stk.hasMoreTokens())
					{
						temp = stk.nextToken();
						
						if (temp.equals("rand(8)"))
						{
							temp = "Math.random() * 9";
						}
						
						else if(temp.equals("rand(25)"))
						{
							temp = "Math.random() * 26";
						}
						
						else if(temp.equals("rand(9)"))
						{
							temp = "Math.random() * 9 + 1";
						}
						
						else
						{
						temp = temp.replace("(", "[");
						temp = temp.replace(",", "][");
						temp = temp.replace(")", "]");
						}
						
						outputString += temp + " ";
						
					}
					outputString = outputString.replace("Math.random() * 9 + 1", "(int) (Math.random() * 9 + 1)");
					outputString = outputString.replace("5 + Math.random() * 26", "(int) (5 + Math.random() * 26)");
					outputString = outputString.replace("1 + Math.random() * 9", "(int) (1 + Math.random() * 9)");
					outputString += ";";
				}
				
				
				
				//set up while loops
				else if (nextToken.equals("do"))
				{
					outputString += stk.nextToken() + " " + stk.nextToken() + " " + stk.nextToken() + " " + stk.nextToken() + "{";
					
					
				}
				
				//if statements
				else if(nextToken.equals("if"))
				{
					//parse out if statement
					String ifStatement = stk.nextToken().substring(1) + " " + stk.nextToken() + " " + stk.nextToken();
					
					//remove last )
					ifStatement = ifStatement.substring(0, ifStatement.length() -1);
					
					ifStatement = ifStatement.replace("(", "[");
					ifStatement = ifStatement.replace(",", "][");
					ifStatement = ifStatement.replace(")", "]");
					
					outputString = "if (" + ifStatement + ") {";
					
				}
				
				//write(*,*)
				else if (nextToken.equals("write(*,*)"))
				{
					//prints the initial formatting for the new print out
					outputString = "System.out.printf(\"%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s\",";
					
					//parses through the line
					//if the token is an array it will replace the bracket with the java format
					while (stk.hasMoreTokens())
					{
						temp = stk.nextToken();
						outputString += " ";
						if (vars.contains(temp.substring(0,1)))
						{
						temp = temp.replace("(", "[");
						temp = temp.replace(",", "][");
						temp = temp.replace(")", "]");
						}
						
						
						
						outputString += temp;
						
					}
					
					outputString = outputString.replaceAll("'", "\"");
					outputString = outputString.replaceAll("\"\",", "");
					outputString = outputString.replaceAll("___", "___ ___");
					
					//if the fortran program is outputing the text with underlines this will run
					if (outputString.contains("___"))
					{
						outputString = outputString.replace("\"%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s\"", "\"%3s\"");
						
					}
					
					//if the division method is being interpreted we need to change the java print formatting
					if (outputString.contains("/"))
					{
						outputString = outputString.replace("\"%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s\"", "\"%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s\"");
						
					}
					
					outputString += "); System.out.println();";
					
					
					
				}
				
				//if no condition are met, will go to next line
				else
				{
					endOfLine(stk);
				}
			}
			
		
			
			
			//finally prints the output to a .java file
		  out.println(outputString);
		}
		
		out.println("}");
		//closes files
		out.close();
		//Close the input stream
		br.close();
		
		
		
	}

}
