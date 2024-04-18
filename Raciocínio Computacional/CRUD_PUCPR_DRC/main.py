'''
   Raciocínio Computacional
   CRUD - PUC-PR
   ATIVIDADE FORMATIVA - Semana 5
   
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


# Operação 1 - Incluir
def incluir(lista):
    dicionario = {}
    # Tratamento de erro.
    try:
        # Leitura do código!
        codigo = int(input("Código: "))
        
        # Leitura do nome!
        nome = input(f"Nome: ")
        # Criação de um exceção/erro (Nome muito curto/inválido)!
        if len(nome) < 3:
            raise Exception("Nome inválido")
        
        # Leitura do CPF
        cpf = input("CPF: ")

    # Caso de Erro
    except:
        mensagem_erro()
    # Caso de sucesso!
    else:
        dicionario["codigo"] = codigo
        dicionario["nome"] = nome
        dicionario["cpf"] = cpf

        lista.append(dicionario)
        return "{:^35}".format("Cadastrado com sucesso!")


# Operação 2 - Listar
def listar(lista):
    # Verificar se a algum dado na lista.
    if len(lista) == 0:
        print("{:^35}".format("Não há cadastrado."))
        print("{:^35}".format("Acesse a opção de 'Incluir'"))
    else:
        # Listar os dados cadastradados!
        for dicionario in lista:
            print("{:^35}".format(f"Código: {dicionario['codigo']}"))
            print("{:^35}".format(f"Nome: {dicionario['nome']}"))
            print("{:^35}".format(f"CPF: {dicionario['cpf']}"))
            print("-"*35)
        input("Pressione enter para continuar!")


# Operação 3 - Excluir
def remover(lista):
    # Tratamento de erro, para a leitura do código!
    try:
        codigo_remocao = int(input("Informe o código: "))
    except:
        print("{:^35}".format("Você não informou um número ou código válido!"))
    else:
        # Variavel auxiliar para remoção dos dados na lista.
        variavel_aux_remocao = None
        # Percorrer a lista para verificar se o código digitado esta cadastrado
        for dicionario in lista:
            if dicionario["codigo"] == codigo_remocao:
                variavel_aux_remocao = dicionario
                break
        # Retorno se o dado foi ou não removido.
        if variavel_aux_remocao == None:
            return False
        else:
            lista.remove(variavel_aux_remocao)
            return True


# Operação 4 - Alterar
def alterar(lista):
    # Variavel auxiliar, serve para verificar se o código existe.
    verificar = remover(lista)

    # Caso o código exista.
    if verificar:
        print("{:^35}".format("Informe os dados para a atualização!"))
        incluir(lista)
        print("{:^35}".format("Atualização realizada com Sucesso!"))
    # Caso o código não está cadastrado.
    else:
        print("{:^35}".format("Verifique o código para edição"))


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
    lista_estudantes = [
        {"codigo": 1, "nome": "Lucas", "cpf": "999"}, 
        {"codigo": 2, "nome": "Pedro", "cpf": "555"}
    ]

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

                # Opção de Incluir.
                if opcao_crud == 1:
                    crud = "Incluir"
                    mensagem_operacao_realizada(crud)
                    incluir(lista_estudantes)

                # Opção de Listar
                elif opcao_crud == 2:
                    crud = "Listar"
                    mensagem_operacao_realizada(crud)
                    listar(lista_estudantes)

                # Opção de Excluir
                elif opcao_crud == 3:
                    crud = "Excluir"
                    mensagem_operacao_realizada(crud)
                    foi_removido = remover(lista_estudantes)
                    if foi_removido:
                        print("{:^35}".format("Removido da base de dados!"))
                    else:
                        print("{:^35}".format("Código informado não encontrado!"))

                # Opção de Alterar
                elif opcao_crud == 4:
                    crud = "Alterar"
                    mensagem_operacao_realizada(crud)
                    alterar(lista_estudantes)

                # Voltar para o menu inicial.
                elif opcao_crud == 5:
                    break

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
