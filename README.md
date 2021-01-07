# API REST Github Repos

API REST para listar todos os repositórios de um determinado usuário do GitHub.

## Rodando a aplicação

É possível rodar a aplicação direto pelo plugin do maven, executando:
```
./mvnw spring-boot:run
```

## Gerando uma imagem do docker

Para gerar uma imagem do docker, é necessário compilar o projeto, com o seguinte comando:

```
./mvnw clean install
```

Após isso basta construir a imagem do docker rodando:
```
docker build -t github-repos .
```

E será criado um container com o nome **github-repos**.

Por fim, para rodar o container, basta executar:

```
docker run -p 8080:8080 github-repos
```

## Autenticação JWT

Para gerar o token JWT é necessário fazer uma requisição para ```/auth```, o Token virá no cabeçalho da requisição, da seguinte forma:

```
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxMDg4NzM4M30.92Od4EKqOCLC0xnIME7H2b0tmG-E_tPi7Vz5puUkcy0tFAwbMs253E34wQUYo9RRCfGFbbBz-cTqqBV7Rg5ZXA
```

O comando abaixo faz uma requisição para a aplicação rodando local na porta 8080 e extrai o token do cabeçalho:
```
curl -s -i -X POST -H "Content-Type: application/json" --data '{"username":"admin", "password":"12345"}' http://localhost:8080/auth | grep Authorization | awk '{print $2 " " $3}'
```

## Gerando token do Github

Para gerar o token que é usado no campo "password" do endpoint ```/list```, é necessário ir na sua conta do Github e acessar Settings > Developer Settings e Personal access tokens e gerar um novo token.

Mais detalhes na documentação oficial: https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/creating-a-personal-access-token

## Documentação da API

A documentação da API está disponível no endereço ```/swagger-ui.html```

