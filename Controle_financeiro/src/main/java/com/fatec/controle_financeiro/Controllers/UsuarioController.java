package com.fatec.controle_financeiro.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.controle_financeiro.entites.User;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Notnull;
//import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    //http://localhost:<port>/api/usuario/register
    //POST
    //Parametro: @RequestBody => enviar no corpo da requisicao (body)

    //@PostMapping => POST - CRIACAO / CONSULTAS COM PARAMETROS NO CORPO DA REQUISICAO
    //@GetMapping => GET - CONSULTAS
    //@PutMapping -> PUT - ALTERACAO
    //@DeleteMapping -> DELETE - DELETAR
    //@PatchMapping -> PATCH - ANEXAR/ALTERAR

    /**
     * @param usuario
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User usuario) {
        if (usuario.getName() ==null || usuario.getName().trim().isEmpty()){
            return ResponseEntity.badRequest().body("Usuário inválido! ");
        }
        if(usuario.getAge() <=0){
            return ResponseEntity.badRequest().body("Idade inválida! ");
        }
        return ResponseEntity.ok("Bem-vindo, " + usuario.getName() + "! Você tem " + usuario.getAge() + " anos.");
    }

    @PostMapping("/register/{name}/{age}")
    public String registerUser(@PathVariable String name, @PathVariable int age) {

        User usuario = new User();
        usuario.setName(name);
        usuario.setAge(age);

        return "Bem-vindo, " + usuario.getName() + "! Você tem " + usuario.getAge() + " anos.";
    }
}
