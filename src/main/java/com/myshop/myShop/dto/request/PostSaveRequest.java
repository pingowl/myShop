package com.myshop.myShop.dto.request;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostSaveRequest {

    @NotNull
    private String title;
    private String content;
    @NotNull
    private String author;

}
