package com.abby.hms.service;

import com.abby.hms.model.ScheduleSlot;

import java.util.List;

public interface ScheduleSlotService {
    ScheduleSlot saveScheduleSlot(ScheduleSlot scheduleSlot);
    ScheduleSlot getScheduleSlotById(Long id);
    List<ScheduleSlot> getAllScheduleSlots();
    void deleteScheduleSlot(Long id);
    ScheduleSlot updateScheduleSlot(Long id, ScheduleSlot scheduleSlotDetails);
}
