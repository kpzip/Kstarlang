malloc PROTO
free PROTO

.data


.code
getmemory PROC
	; size in rdi, pointer in rax
	mov rcx, rdi
	call malloc
	ret

getmemory ENDP

freememory PROC
	; pointer to memory in rdi
	mov rcx, rdi
	call free
	ret

freememory ENDP

END