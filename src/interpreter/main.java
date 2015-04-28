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
		
		// Open the file
		FileInputStream fstream = new FileInputStream("C:/g77/bin/FORTRANZ.for");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("interpreted.java")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		int i = 1;
		
		
		
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
				
				//write(*,*)
				else if (nextToken.equals("write(*,*)"))
				{
					outputString = "System.out.println(";
					
					while (stk.hasMoreTokens())
					{
						outputString += " " + stk.nextToken();
						
					}
					
					
					outputString += ");";
					outputString = outputString.replaceAll("'", "\"");
					System.out.println("'Addition'");
					
				}
				
				//call subroutines
				else if (nextToken.equals("call"))
				{
					outputString = stk.nextToken() + "();";
					
				}
				
				//create subroutines
				else if (nextToken.equals("subroutine"))
				{
					outputString = "public static void " + stk.nextToken() + " {";
					
				}
				
				//declare integer values
				else if (nextToken.equals("integer"))
				{
					
					String temp = stk.nextToken();
					
					//if integer is followed by ::
					if (!temp.equals("::"))
					{
						outputString = "int";
						
						outputString += " " + temp + ";";
						
						vars.add(temp);
					}
					
					
					else
					{
						String temp2 = stk.nextToken();
						
						//if it is an array
						if (temp2.length() > 1)
						{
							outputString += "int[][] " + temp2.substring(0, 1) + " = new int";
							
							temp2 = temp2.replace("(", "[");
							temp2 = temp2.replace(",", "][");
							temp2 = temp2.replace(")", "]");
							
							outputString += temp2.substring(1) + ";";
							vars.add(temp2.substring(0, 1));
						}
						
						//not an array
						else
						{
							outputString = "int";
							outputString += " " + temp2 + " " + stk.nextToken() + " " + stk.nextToken() + ";";
							vars.add(temp2);
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
						String temp3 = stk.nextToken();
						
						
						temp3 = temp3.replace("(", "[");
						temp3 = temp3.replace(",", "][");
						temp3 = temp3.replace(")", "]");
						
						outputString += temp3 + " ";
						
					}
					
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
				
				
				else
				{
					endOfLine(stk);
				}
			}
			
		
			
			
		System.out.println(vars.toString());
		  out.println(outputString);
		}
		
		out.println("}");

		out.close();
		//Close the input stream
		br.close();
		
		
		
	}

}
