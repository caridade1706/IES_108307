**Exercício 1.5**

Foram criados 2 projetos maven para a resolução deste exercício. 
- Projeto ipmaapiclient que contém os dados da API, ou seja, contém os ficheiros responsáveis por obterem as temperaturas das cidades. 
-O projeto anycityforecast que contém uma main simples, onde são chamadas aa funções criadas no primeiro projeto, que escolhe uma cidade aleatoriamente e returna os seus dados. Esta segunda também é responsável por imprimir as insformções e por repetir de 20 em 20 segundos o ciclo.

**Comandos **

O comando seguinte foi utilizado de modo a atualizar as funções realizadas do lado da api, de modo a funcionarem corretamente quando chamadas.

```
mvn clean install -U
```

De modo a verificar se está tudo correto efetuou-se os seguintes comandos

```
mvn package

mvn exec:java -Dexec.mainClass="ua.deti.iesanycityforecast" -Dexec.cleanupDaemonThreads=false
```

**Dockerize**

De modo a correr o programada no Docker adicionou-se os seguintes plugins no pom.xml do programa principal

```
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version> <!-- Make sure to use the latest version -->
                <executions>
                    <execution>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>ua.deti.ies.anycityforecast</mainClass>
                                </transformer>
                            </transformers>
                            <filters>
                                <filter>
                                    <artifact>org.apache.logging.log4j:log4j-api</artifact>
                                    <includes>
                                        <include>*/</include>
                                    </includes>
                                </filter>
                                <filter>
                                    <artifact>org.apache.logging.log4j:log4j-core</artifact>
                                    <includes>
                                        <include>*/</include>
                                    </includes>
                                </filter>
                            </filters>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

```

De seguida executou-se
 mvn clean package

que gerou o ficheiro jar.

Logo de seguida criou-se a imagem 

  docker build -t anycityforecast:1.0 

cuja foi executada na interface no Docker e executou de forma correta o programa.