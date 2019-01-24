# Lucas José da Cunha

## Objetivo
Repositório para manter os arquivos da disciplina de POO

## Guia prático do uso do GIT

###Criando um novo repositório
```
git init
```
###Obter um repositório
#####Crie uma cópia de trabalho em um repositório local executando o comando
```
git clone /caminho/para/o/repositório
```
*ou*
#####Quando usar um servidor remoto, seu comando será
```
git clone usuário@servidor:/caminho/para/o/repositório
```
### Adicionar arquivos no stage:
```
git add {nome do arquivo}
```
*ou*
```
git add .
```

### Enviar / commitar o código:
```
git commit -m "{mensagem do commit}"
```

### Ver o log: 
```
git log

```
### Ver a situação do working dir:
```
git status
```

### Enviar as alterações para o repositório remoto:
```
git push {nome_do_branch}
```

### Trocar para outro branch:
```
git checkout {nome_do_branch}
```

### Juntar o branch atual com outro branch:
```
git merge {nome_do_branch}
```
