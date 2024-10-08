package ru.buyankin.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailParams {
    private String id;
    private String emailTo;
}
