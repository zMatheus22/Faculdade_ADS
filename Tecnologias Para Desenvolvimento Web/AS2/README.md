# 🚀 Atividade 2 - Tecnologias Para Desenvolvimento Web

| Informação                  | Detalhes                                    |
| :---                        | :---                                        |
| **Estudante**               | Matheus Vinicyus Strada                     |
| **Curso**                   | Análise e Desenvolvimento de Sistemas       |
| **Matéria**                 | Tecnologias Para Desenvolvimento Web        |
| **Atividade**               | Implementação de Cadastro, Login e Perfil com Firebase |
| **Tecnologias**             | React, Firebase Auth, Firestore, React Router Dom |

---

## 📝 Descrição do Projeto

Esta é uma aplicação desenvolvida em React que simula um fluxo completo de usuário. O objetivo principal é integrar o **Firebase Authentication** para gestão de acesso e o **Cloud Firestore** para o armazenamento de dados complementares dos usuários.

## 📱 Páginas da Aplicação

1.  **Cadastro:** Criação de conta via E-mail/Senha e salvamento de dados adicionais (Nome, Sobrenome, Data de Nascimento) no Firestore, vinculados pelo UID.
2.  **Login:** O usuário deve logar com o email e senha cadastrados para acessar o sistema, caso contrário aparecerá uma mensagem de erro.
3.  **Principal (Dashboard):** Área restrita que recupera e exibe as informações do perfil do usuário logado em tempo real.

---

## 🛠️ Tecnologias Utilizadas

*   [React.js](https://reactjs.org/)
*   [Firebase](https://firebase.google.com/) (Auth e Firestore)
*   [React Router Dom](https://reactrouter.com/)
*   [Dotenv](https://www.npmjs.com/package/dotenv) (Gerenciamento de variáveis de ambiente)

---

## ⚙️ Configuração e Instalação

### 1. Pré-requisitos
Certifique-se de ter o **Node.js** instalado em sua máquina.

### 2. Clonando
```bash
git clone <repository-url>
```

### 3. Instalando
```bash
npm install
```

### 4. Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto e adicione as seguintes variáveis de ambiente:

```env
REACT_APP_API_KEY=sua_api_key
REACT_APP_AUTH_DOMAIN=seu_auth_domain
REACT_APP_PROJECT_ID=seu_project_id
REACT_APP_STORAGE_BUCKET=seu_storage_bucket
REACT_APP_MESSAGING_SENDER_ID=seu_messaging_sender_id
REACT_APP_APP_ID=seu_app_id
```

### 5. Iniciar a aplicação
```bash
npm start
```