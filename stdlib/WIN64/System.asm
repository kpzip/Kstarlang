MessageBoxA PROTO
WriteConsoleA PROTO
GetStdHandle PROTO

.data
	written dq ?

.code
print PROC
	; input: pointer to location to print in rdi, output: number of characters printed stored in rax

	mov ecx, -11
	call GetStdHandle

	mov rcx, rax
	mov rdx, rdi
	mov r8, 13
	lea r9, written
	push 0
	call WriteConsoleA
	mov rax, written
	add rsp, 8
	ret

print ENDP

END