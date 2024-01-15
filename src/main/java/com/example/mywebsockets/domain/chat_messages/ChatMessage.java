package com.example.mywebsockets.domain.chat_messages;

import com.example.mywebsockets.domain.BaseEntity;
import com.example.mywebsockets.domain.chatroom.ChatRoom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_message")
public class ChatMessage extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ChatRoom chatRoom;

    @Column(name = "content")
    @Size(max = 2048)
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageStatus messageStatus;
}
