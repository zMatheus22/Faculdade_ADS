'''
   Raciocínio Computacional
   CRUD - PUC-PR
   ATIVIDADE SOMATIVA 1 - Semana 4
   
   @Curso: Análise e Desenvolvimento de Sistemas
   @Autor: Matheus Vinicyus Strada
'''

# Leitura e tratamento de ERRO das opções dos menus: menu principal e menu crud.
def leitura_opcao_menu():
    while True:
        # Tratamento de Erro dos menus
        try:
            opcao = int(input("Digite um dos valores válido acima: "))
        # Caso de Erro de tipo ('String/Texto'), imprime uma mensagem
        except (ValueError, TypeError):
            mensagem_invalida()
        # Caso o usuário feche o sistema brutalmente (Ctrl + C)
        except KeyboardInterrupt:
            print("\n")
            opcao = 0        
            break
        # Caso de Sucesso!
        else:
            # Sai do loop se a entrada for válida
            break
    return opcao


# Menu inicial do sistema escolar.
def menu_inicial():
    print('='*35)
    print("{:^35}".format("Sistema Acadêmico"))
    print('='*35)
    print("1. Estudante")
    print("2. Disciplina")
    print("3. Professor")
    print("4. Turma")
    print("5. Matrícula")
    print("0. Sair\n")

    return leitura_opcao_menu()


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

    return leitura_opcao_menu()


# Mensagem para as opções em desenvolvimento.
def mensagem_opcao_desenvolvimento(opcao):
    print("-"*35)
    print("{:^35}".format("EM DESENVOLVIMENTO!!!"))
    print("{:^35}".format(f"A opção: '{opcao}' está desativada."))
    print("{:^35}".format("Tente outra opção!"))
    print("-"*35)


# Mensagem da operação realizada no crud.
def mensagem_operacao_realizada(opcao):
    print("+"*35)
    print("{:^35}".format(f"{opcao}"))
    print("+"*35)


# Mensagem de Erro!
def mensagem_erro():
    print("!"*35)
    print("{:^35}".format(f"ERRO - Informação não cadastrada"))
    print("!"*35)


# Mensagem para as opções inválidas!
def mensagem_invalida():
    print("!"*35)
    print("{:^35}".format(f"ERRO - Opção inválida."))
    print("{:^35}".format(f"Tente novamente!"))
    print("!"*35)


# Mensagem de finalização do Sitema.
def mensagem_finalizar():
    print("~"*35)
    print("{:^35}".format("Obrigado por utilizar!"))
    print("{:^35}".format("Espero que tenha gostado!"))
    print("{:^35}".format("Sistema Finalizado!"))
    print("~"*35)


# Função principal do sistema.
def main():
    # Inicialização das variáveis.
    estudantes = []
    while True:
        # Apresentação e leitura do menu inicial.
        opcao_menu_inicial = menu_inicial()        

        # Opções em desenvolvimento!
        if opcao_menu_inicial in (2, 3, 4, 5):
            if opcao_menu_inicial == 2:
                escola_opcao = "Disciplina"
            elif opcao_menu_inicial == 3:
                escola_opcao = "Professor"
            elif opcao_menu_inicial == 4:
                escola_opcao = "Turma"
            elif opcao_menu_inicial == 5:
                escola_opcao = "Matrícula"

            mensagem_opcao_desenvolvimento(escola_opcao)

        # Opções válida do menu inical.
        elif opcao_menu_inicial == 1:
            escola_opcao = "Estudante"
            while True:
                # Apresentação e leitura do menu do CRUD.
                opcao_crud = menu_CRUD(escola_opcao)

                # Opções ativas do menu do CRUD
                if opcao_crud in (1, 2, 5):
                    # Opção de Incluir.
                    if opcao_crud == 1:
                        crud = "Incluir"
                        mensagem_operacao_realizada(crud)
                        # Tratamento de erro.
                        try:
                            # Leitura do nome!
                            nome = input(f"Informe o nome do estudante: ")
                            # Criação de um exceção/erro (Nome muito curto/inválido)!
                            if len(nome) < 3:
                                raise Exception("Nome inválido")
                        # Caso de Erro
                        except Exception as erro:
                            print("{:^35}".format(erro[0]))
                            mensagem_erro()
                        # Caso de sucesso!
                        else:
                            estudantes.append(nome)
                            print("{:^35}".format("Estudante cadastrado com sucesso!"))

                    # Opção de Listar
                    elif opcao_crud == 2:
                        crud = "Listar"
                        mensagem_operacao_realizada(crud)

                        if len(estudantes) == 0:
                            print("{:^35}".format("Não há estudantes cadastrados."))
                            print("{:^35}".format("Acesse a opção de 'Incluir'"))
                        else:
                            # Listanto a posição e o nome dos estudantes que foram cadastrados!
                            for posicao, estudante in enumerate(estudantes):
                                print(f"{posicao + 1}° - {estudante}")

                    # Voltar para o menu inicial.
                    elif opcao_crud == 5:
                        break

                # Opções em desenvolvimento do menu do CRUD!
                elif opcao_crud in (3, 4):
                    if opcao_crud == 3:
                        crud = "Excluir"
                    elif opcao_crud == 4:
                        crud = "Alterar"

                    mensagem_opcao_desenvolvimento(crud)

                # Opção inválida da váriavel "opcao_crud"
                else:
                    mensagem_invalida()

        # Opção para saír do Sistema (menu inicial)!
        elif opcao_menu_inicial == 0:
            break

        # Opção inválida do menu inicial, váriavel "opcao_menu_inicial"
        else:
            mensagem_invalida()

    # Mensagem de finalização do Sistema
    mensagem_finalizar()


# Execução da função principal!
main()
