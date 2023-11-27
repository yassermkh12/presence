package com.example.presence.services;

import com.example.presence.entitiesDto.PresenceDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;

public interface IPresenceService {
    public List<PresenceDto> getAllPresence();
    public PresenceDto getPresenceById(Long id) throws NotFoundException;
    public PresenceDto savePresence(PresenceDto presenceDto);
    public PresenceDto updatePresence(Long id, PresenceDto presenceDto) throws NotFoundException;
    public void deletePresence(Long id);
}
