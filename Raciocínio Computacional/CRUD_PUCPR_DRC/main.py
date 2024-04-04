'''
   Raciocínio Computacional
   CRUD - PUC-PR
   ATIVIDADE FORMATIVA - Semana 3
   
   @Curso: Análise e Desenvolvimento de Sistemas
   @Autor: Matheus Vinicyus Strada
'''

# Menu inicial do sistema escolar.
def menu_Inicial():
    print('='*35)
    print("{:^35}".format("Sistema Acadêmico"))
    print('='*35)
    print("1. Estudante")
    print("2. Disciplina")
    print("3. Professor")
    print("4. Turma")
    print("5. Matrícula")
    print("0. Sair\n")
    opcao_menu_inicial = int(input("Digite um dos valores válido acima: "))

    return opcao_menu_inicial


# Menu de operação do CRUD.
def menu_CRUD(opcao):
    print('='*35)
    print("{:^35}".format(f"Menu de operações - {opcao}"))
    print('='*35)
    print("1. Incluir")
    print("2. Listar")
    print("3. Excluir")
    print("4. Alterar")
    print("5. Voltar\n")

    opcao_crud = int(input("Digite um dos valores válido acima: "))
    return opcao_crud


# Mensagem de finalização do Sitema.
def mensagem_finalizar():
    print("Obrigado!")
    print("Sistema finalizado!")


def main():
    while True:
        # Apresentação e leitura da opção inicial do sistema.
        opcao_menu_inicial = menu_Inicial()

        # Opções válida do menu
        if opcao_menu_inicial in (1, 2, 3, 4, 5):
            while True:
                if opcao_menu_inicial == 1:
                    escola_opcao = "Estudante"
                elif opcao_menu_inicial == 2:
                    escola_opcao = "Disciplina"
                elif opcao_menu_inicial == 3:
                    escola_opcao = "Professor"
                elif opcao_menu_inicial == 4:
                    escola_opcao = "Turma"
                elif opcao_menu_inicial == 5:
                    escola_opcao = "Matrícula"

                # Apresentação e leitura da opção do CRUD.
                opcao_crud = menu_CRUD(escola_opcao)

                if opcao_crud in (1, 2, 3, 4, 5):
                    if opcao_crud == 1:
                        crud = "Incluir"
                    elif opcao_crud == 2:
                        crud = "Listar"
                    elif opcao_crud == 3:
                        crud = "Excluir"
                    elif opcao_crud == 4:
                        crud = "Alterar"
                    elif opcao_crud == 5:
                        # Voltar para o menu inial.
                        break
                    
                    # Apresentação da opção do usuário
                    print(f"Opção selecionada foi: {crud}")

                # Opção inválida da váriavel "opcao_crud"
                else:
                    print("Opção inválida!")
                
        # Opção para saír do Sistema
        elif opcao_menu_inicial == 0:
            break

        # opção inválida da váriavel "opcao_menu_inicial"
        else:
            print("Opção inválida!")


main()
mensagem_finalizar()
