package ru.itmo.webmail.model.repository;

import ru.itmo.webmail.model.domain.Talk;

import java.util.List;

public interface TalkRepository {
    void addMessage(long id,String message, long from, long to);
    List<Talk> getMessagesById(long id);
}
