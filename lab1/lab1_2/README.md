**Exercício 1.2**

De modo a inciar um projeto utilazamos a seguinte linha, tendo em conta que esta deve ser alterada de projeto para projeto de modo a conter informação mais especifica (por exemplo o *'groupId'* e o *'artifactID'*)

```
$ mvn archetype:generate -DgroupId=deti.ua.ies -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Para compilar
```
mvn package
```

Para correr o programa (deve-se adaptar o *package* e o nome da classe)
```
mvn exec:java -Dexec.mainClass="package.class" 
```

Para correr o programa com argumentos de entrada
```
mvn exec:java -Dexec.mainClass="package.class" -Dexec.args="arg0 arg1 arg2"
```

```
mvn exec:java
```
também resulta.