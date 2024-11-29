package com.fatec.controle_financeiro.entites;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nome;

    public Cliente() {
    }

    public Cliente(int id, String nome) {
        this.id = id;
        setNome(nome);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nome='" + nome + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}