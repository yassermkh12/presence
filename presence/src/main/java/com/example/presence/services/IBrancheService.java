package com.example.presence.services;

import com.example.presence.entitiesDto.BrancheDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;

public interface IBrancheService {
    public List<BrancheDto> getAllBranche();
    public BrancheDto getBrancheById(Long id) throws NotFoundException;
    public BrancheDto saveBranche(BrancheDto brancheDto);
    public BrancheDto updateBranche(Long id, BrancheDto brancheDtoUpdate) throws NotFoundException;
    public void deleteBranche(Long id);

}
