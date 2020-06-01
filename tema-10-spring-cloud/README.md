# Tema 10 

### Necessário:
- Possuir o Docker instalado (instale com: `sudo snap install docker`).
- Deixar as seguintes portas livres : 8080, 8081 e 8082.
- Opcional: Para não ser necessário a utilização do sudo nas execuções do docker utilize o seguinte comando no terminal: `sudo usermod -aG docker $USER` 
- Para aplicar as mudanças reinicie sua máquina.

### GitHub :
1. Vá até a raiz do projeto e faça o comando:`./gradlew clean build` que irá gerar o arquivo github.jar
2. Para criar a docker image do projeto use `docker build -t github .`
3. Assim que a docker image for gerada use o comando: `docker run -p 8080:8080 -d github`
4. Agora acesse http://localhost:8080/github/{githubUser}
5. para dar stop:`docker stop <container-id>`

### Twitter
1. Vá até a raiz do projeto e faça o comando:`./gradlew clean build` que irá gerar o arquivo twitter.jar
2. Para criar a docker image do projeto use `docker build -t twitter .`
3. Assim que a docker image for gerada use o comando: `docker run -p 8081:8081 -d twitter`
4. Agora acesse http://localhost:8081/twitter/{twitterUser}
5. para dar stop:`docker stop <container-id>`

### Integração Twitter-Github:
1. Vá até a raiz do projeto e faça o comando:`./gradlew clean build` que irá gerar o arquivo twittergithub.jar
2. Para fazer a integração é necessário que o Github Server e Twitter Server estejam rodando.
3. Para criar a docker image do projeto use `docker build -t twittergithub .`
4. Assim que a docker image for gerada use o comando: `docker run -p 8082:8082 --network=host -d twittergithub`
5. Agora acesse http://localhost:8082/counter/{githubUser}/{twitterUser}
6. para dar stop:`docker stop <container-id>`

### Hystrix Dashboard
- Para acessar o dashboard de cada projeto:

    - Github: http://localhost:8080/hystrix
    - Twitter: http://localhost:8081/hystrix
    - Twitter-Github: http://localhost:8082/hystrix

- Para monitorar digite a url abaixo no campo do hystrix dashboard.

    - Github: http://localhost:8080/actuator/hystrix.stream
    - Twitter: http://localhost:8081/actuator/hystrix.stream
    - Twitter-Github: http://localhost:8082/actuator/hystrix.stream