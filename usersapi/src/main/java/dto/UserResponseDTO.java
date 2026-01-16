package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @NoArgsConstructor //cria um construtor padrão/vazio (default)
    @AllArgsConstructor //cria um construtor que recebe como parâmetros todos os atributos da classe
    @Data //gera através do lombok automaticamente getters e setters
//resposta do "login" sem senha
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
}
