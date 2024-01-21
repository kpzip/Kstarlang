.data


.code
get PROC
	; index in rdi, pointer to list obj in rsi, pointer to the result in rax

	
	
	mov rsi, qword ptr [rsi]
	

	get_ret:
	lea rax, qword ptr [rsi + 8]
	ret



get ENDP

append PROC
	; pointer to first list obj in rdi, pointer to second list obj in rsi

append ENDP

END