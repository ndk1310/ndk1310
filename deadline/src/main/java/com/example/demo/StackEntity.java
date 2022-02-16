package com.example.demo;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "stack_entity")

public class StackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "list_question")
    private String Question;

    @Column(name = "list_answer")
    private String Answer;


    public Long getId() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getQuestion() {
            return Question;
        }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public void setInfo(StackEntity info){
        this.Question = info.getQuestion();
        this.Answer = info.getAnswer();
    }
}
