# Colabora Ai

### Sumário

- [Requisitos](#requisitos)
- [Rodar o projeto](#rodar-o-projeto)
- [FAQ](#faq)

## Requisitos

- Baixar o [JDK22](https://www.oracle.com/br/java/technologies/downloads/). NÃO CLIQUE NO `sha256`
- Seguir a [Documentação oficial da Oracle de instalação](https://docs.oracle.com/en/java/javase/22/install/installation-jdk-microsoft-windows-platforms.html) para instalar no sistema operacional de sua escolha
- **Youtube** - Instalação Java no Windows : [Clique aqui!](https://www.youtube.com/watch?v=mwGqikr8N5s)

- Qualquer duvida, veja o o [FAQ](#faq) ou chame algum AGES III ou AGES IV no discord!

## Rodar o projeto

Pode fazer utilizando:

- Aperte `F5`
- Utilize no terminal o comando `mvn spring-boot:run`

Ou utilizando docker:

- Criar .env do projeto, na pasta src/main/resources, com as variáveis necessárias.
- `docker-compose up` no terminal.

## FAQ

<details>
  <summary>
    <strong>Erro</strong>: Baixei e instalei o JAVA mas meu prompt de comando não reconhece.
  </summary>
  <p><strong>Solução</strong>: Feche todas as instâncias do prompt de comando e tente novamente. Se não resolveu, faltou configurar as variáveis de ambiente.</p>
</details>

<details>
  <summary>
    <strong>Erro</strong>: Ao rodar <code>flutter doctor</code> você recebe o erro de <img src="https://i.sstatic.net/E3atD.png" alt="cmdline-tools">
  </summary>
  <p><strong>Solução</strong>:</p>
  <p>Abra o Android Studio -> Vá nos menus (Alt + \ ) -> Tools -> SDK Manager -> SDK Tools (No meio da tela, NÃO ESTÁ na lista de abas da esquerda) -> Selecione a caixa ao lado do "Android SDK Command-line Tools (latest) -> Apply</p>
</details>
