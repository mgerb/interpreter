		program hello
		implicit none
		
		
		write(*,*) 'Addition'
		call addition
		write(*,*) 'Subtraction'
		call subtraction
		write(*,*) 'Multiplication'
		call multiplication
		write(*,*) 'Division'
		call division
		
		read(*,*)
		end program hello
		
		
		subroutine addition
		
			integer :: i(2,5)
			integer :: j = 1
			integer :: k = 1
		
			do while (j <= 10)
			
				do while (k <= 5)
				
					i(1,k) = 3
					i(2,k) = 4
					
					k = k + 1
			
				end do
				
			write(*,*) '  ', i(1,1), '  ', i(1,2), '  ', i(1,3), '  ', i(1,4), '  ', i(1,5)
			write(*,*) ' +', i(2,1), ' +', i(2,2), ' +', i(2,3), ' +', i(2,4), ' +', i(2,5)
			write(*,*) ' ___ ___ ___ ___ ___'
			write(*,*) ' '
			
			j = j + 1
			k = 1
			end do
			
		end subroutine
		
		
		subroutine subtraction
			integer :: i(2,5)
			integer :: j = 1
			integer :: k = 1
			integer l
			
			do while (j <= 10)
			
				do while (k <= 5)
				
					i(1,k) = 3
					i(2,k) = 4
					
					if (i(1,k) < i(2,k)) then
						l = i(1,k)
						i(1,k) = i(2,k)
						i(2,k) = l
					end if
					
					k = k + 1
			
				end do
				
			write(*,*) '  ', i(1,1), '  ', i(1,2), '  ', i(1,3), '  ', i(1,4), '  ', i(1,5)
			write(*,*) ' -', i(2,1), ' -', i(2,2), ' -', i(2,3), ' -', i(2,4), ' -', i(2,5)
			write(*,*) ' ___ ___ ___ ___ ___'
			write(*,*) ' '
			
			j = j + 1
			k = 1
			end do
		end subroutine
		
		subroutine multiplication
		
			integer :: i(2,5)
			integer :: j = 1
			integer :: k = 1
		
			do while (j <= 10)
			
				do while (k <= 5)
				
					i(1,k) = 3
					i(2,k) = 4
					
					k = k + 1
			
				end do
				
			write(*,*) '  ', i(1,1), '  ', i(1,2), '  ', i(1,3), '  ', i(1,4), '  ', i(1,5)
			write(*,*) ' *', i(2,1), ' *', i(2,2), ' *', i(2,3), ' *', i(2,4), ' *', i(2,5)
			write(*,*) ' ___ ___ ___ ___ ___'
			write(*,*) ' '
			
			j = j + 1
			k = 1
			end do
			
		end subroutine
		
		subroutine division
		
			integer :: i(2,5)
			integer :: j = 1
			integer :: k = 1
		
			do while (j <= 10)
			
				do while (k <= 5)
				
					i(1,k) = 3
					i(2,k) = 4
					
					if (i(1,k) < i(2,k)) then
						l = i(1,k)
						i(1,k) = i(2,k)
						i(2,k) = l
					end if
					
					k = k + 1
			
				end do
				
			write(*,*) i(1,1), '/', i(2,1), ' ', i(1,2), '/', i(2,2), ' ', i(1,3), '/', i(2,3), ' ', i(1,3), '/', i(2,3), ' ', i(1,4), '/', i(2,4), ' ', i(1,5), '/', i(2,5)  
			write(*,*) ' '
			
			j = j + 1
			k = 1
			end do
			
		end subroutine