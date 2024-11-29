package com.fatec.controle_financeiro.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercícios1")
public class ExercicioController {
    
    @GetMapping()
        public String HelloWorld(){
            return "Hello";
        }

    @GetMapping("/hello1")
    public String HelloWorld1(){
        return "Hello1";
    }

    //@PathVariable = anotacao para definir que a variavel nome que é do tipo String será recebida pelo parametro {nome}

    @GetMapping("/reverter-nome/{nome}")
    String reverterNome(@PathVariable String nome){
        return new StringBuilder(nome).reverse().toString();
    }
    
    @PostMapping("/reverter-nome-requisicao-corpo")
    String reverterNomeRequisicaoCorpo(@RequestBody String nome){
        return new StringBuilder(nome).reverse().toString();
    }

    ///api/exercicios1/2/par-ou-impar => @GetMapping("/{numero}/par-ou-impar")
    ///api/exercicios1/par-ou-impar/2 => @GetMapping("/par-ou-impar/{numero}")
    @GetMapping("/par-ou-impar/{numero}")
    String verificarParOuImpar(@PathVariable Integer numero) {
        if (numero % 2 == 0) {
            return "Par";
        } else {
            return "Ímpar";
        }
    }

    //Requisição que precisamos mandar no hoppscotch
    //

    @PostMapping("/create-user")
    public String CreateUser(@RequestBody User user){
        return "Olá, "+user.nome+" você tem "+user.idade+" anos.";
    }

    public class User {
        private String nome;
        private Integer idade;

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public Integer getIdade() {
            return idade;
        }
        public void setIdade(Integer idade) {
            this.idade = idade;
        }
        
    }
    
}
