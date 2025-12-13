package com.example.conflict_tracker.service;

import com.example.conflict_tracker.domain.Conflict;
import com.example.conflict_tracker.domain.ConflictRepository;
import com.example.conflict_tracker.domain.Country;
import com.example.conflict_tracker.domain.CountryRepository;
import com.example.conflict_tracker.web.ConflictDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConflictServiceImplement implements ConflictService {
    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;

    public ConflictServiceImplement(ConflictRepository conflictRepository, CountryRepository countryRepository) {
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<ConflictDto> findAll() {
        return conflictRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public ConflictDto findById(int id) {
        Conflict conflict = conflictRepository.findById((Long.valueOf(id)))
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        return toDto(conflict);
    }

    @Override
    public ConflictDto create(ConflictDto conflictDto) {
        Conflict conflict = toEntity(conflictDto);
        Conflict savedConflict = conflictRepository.save(conflict);
        return toDto(savedConflict);
    }

    @Override
    public ConflictDto update(int id, ConflictDto conflictDto) {
        Conflict exists = conflictRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        exists.setName(conflictDto.getName());
        exists.setStartConflict(conflictDto.getStartConflict());
        exists.setStatus(conflictDto.getStatus());
        exists.setDescription(conflictDto.getDescription());

        List<Country> countries = conflictDto.getCountryId() == null ? List.of() :
                conflictDto.getCountryId().stream()
                        .map(countryId -> countryRepository.findById(Long.valueOf(countryId))
                                .orElseThrow(() -> new RuntimeException("Country not found: " + countryId)))
                        .toList();

        exists.setCountries(countries);
        Conflict save = conflictRepository.save(exists);
        return toDto(save);
    }

    @Override
    public void delete(int id) {
        conflictRepository.deleteById((long) id);
    }

    private ConflictDto toDto(Conflict conflict) {
        ConflictDto dto = new ConflictDto();
        dto.setId(conflict.getId());
        dto.setName(conflict.getName());
        dto.setStartConflict(conflict.getStartConflict());
        dto.setStatus(conflict.getStatus());
        dto.setDescription(conflict.getDescription());
        Set<Integer> countryIds = conflict.getCountries().stream()
                .map(Country::getId)
                .collect(Collectors.toSet());
        dto.setCountryId(countryIds);
        return dto;
    }
    private Conflict toEntity(ConflictDto dto) {
        Conflict conflict = new Conflict();
        conflict.setName(dto.getName());
        conflict.setStartConflict(dto.getStartConflict());
        conflict.setStatus(dto.getStatus());
        conflict.setDescription(dto.getDescription());
        if (dto.getCountryId() != null) {
            List<Country> countries = dto.getCountryId() == null ? List.of() :
                    dto.getCountryId().stream()
                            .map(id -> countryRepository.findById(Long.valueOf(id))
                                    .orElseThrow(() -> new RuntimeException("Country not found: " + id)))
                            .toList();

            conflict.setCountries(countries);
        }
        return conflict;
    }
}
