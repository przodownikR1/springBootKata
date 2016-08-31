package pl.java.scalatech.web.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyMessage {

    private String text;
    private int id;
    private String fromUser;
    private String toUser;
}
