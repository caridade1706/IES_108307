**Exercício 1.3**

**Introdução ao *git***<br>
Lista de alguns dos comandos mais habituais com o *git*<br><br>
**Criar novo repositório**

	git init

**Verificar estado dos arquivos/diretórios**

	git status

**Adicionar um arquivo em específico**

	git add meu_arquivo.txt

 **Adicionar um diretório em específico**

	git add meu_diretorio

**Adicionar todos os arquivos/diretórios**
	
	git add .	
	
**Commit de um arquivo**
	
	git commit meu_arquivo.txt

**Commit de vários arquivos**

	git commit meu_arquivo.txt meu_outro_arquivo.txt
	
**Commit com mensagem**

	git commit meuarquivo.txt -m "minha mensagem de commit"

**Commit de tudo com mensagem (git add .)**

	git commit -m "minha mensagem de commit"

**Remover arquivo**

	git rm meu_arquivo.txt


**Exibir histórico**
	
	git log
	

**Adicionar ficheiro .gitignore** 

    touch .gitignore

**Logger**

Nesta nova localização foi criado, então, um logger, sendo as operações executadas escritas no terminal e num ficheiro, 'logs.log'. 
Foi usada a biblioteca auxiliar **Log4j2**

Links usados para criar os ficheiros: 
- https://www.baeldung.com/java-logging-intro
- https://howtodoinjava.com/log4j2/log4j2-xml-configuration-example/


