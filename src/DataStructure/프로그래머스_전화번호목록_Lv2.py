def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if phone_book[i] in phone_book[i+1] and phone_book[i+1].index(phone_book[i]) == 0:
            return False
    return True

arr = ['123','456','78']
print(solution(arr))