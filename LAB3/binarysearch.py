numeritos = [5,12,17,23,38,45,77,84,90]
numeritos2 = [17,12,15,23,38,45,84,84,84]

def binarysearch(a, b):
    baja = 0
    alta = len(a) - 1
    while (baja <= alta):
        media = int((alta+baja)/2)
        if a[media] == b:
            return str(media)
        else:
            if(b < a[media]):
                alta = media - 1
            else:
                baja = media + 1
    return "-1"
    
print("Numero ubicado en: "+ binarysearch(numeritos, 23))
print("Numero ubicado en: "+ binarysearch(numeritos, 84))

