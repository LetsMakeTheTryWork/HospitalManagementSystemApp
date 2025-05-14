package com.abby.hms.service;

import com.abby.hms.model.ScheduleSlot;
import com.abby.hms.repository.ScheduleSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleSlotServiceImpl implements ScheduleSlotService {

    @Autowired
    private ScheduleSlotRepository scheduleSlotRepository;

    @Override
    public ScheduleSlot saveScheduleSlot(ScheduleSlot scheduleSlot) {
        return scheduleSlotRepository.save(scheduleSlot);
    }

    @Override
    public ScheduleSlot getScheduleSlotById(Long id) {
        Optional<ScheduleSlot> scheduleSlot = scheduleSlotRepository.findById(id);
        return scheduleSlot.orElse(null);
    }

    @Override
    public List<ScheduleSlot> getAllScheduleSlots() {
        return scheduleSlotRepository.findAll();
    }

    @Override
    public void deleteScheduleSlot(Long id) {
        scheduleSlotRepository.deleteById(id);
    }

    @Override
    public ScheduleSlot updateScheduleSlot(Long id, ScheduleSlot scheduleSlotDetails) {
        Optional<ScheduleSlot> scheduleSlot = scheduleSlotRepository.findById(id);

        if (scheduleSlot.isPresent()) {
            ScheduleSlot existingSlot = scheduleSlot.get();
            existingSlot.setSlotTime(scheduleSlotDetails.getSlotTime());
            existingSlot.setDoctor(scheduleSlotDetails.getDoctor());
            // Add more fields as necessary

            return scheduleSlotRepository.save(existingSlot);
        } else {
            return null;
        }
    }
}
