/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thoughtworks.capability.parking.interfaces.console;

import com.thoughtworks.capability.parking.application.ParkingService;
import com.thoughtworks.capability.parking.application.impl.ParkingServiceImpl;
import com.thoughtworks.capability.parking.domain.parkingBoy.*;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;
import com.thoughtworks.capability.parking.infrastructure.memoryRepository.ParkingBoyRepositoryMemoryImpl;
import com.thoughtworks.capability.parking.infrastructure.memoryRepository.TicketRepositoryMemoryImpl;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {

        ParkingBoyRepository parkingRepo = new ParkingBoyRepositoryMemoryImpl();
        TicketRepository ticketRepo = new TicketRepositoryMemoryImpl();

        ParkingService parkingService = new ParkingServiceImpl(parkingRepo, ticketRepo);

        parkingService.parking(new ParkingBoyId("parking-boy-001"), new LicensePlate("川A8888"));
        parkingService.parking(new ParkingBoyId("parking-boy-001"), new LicensePlate("川A8889"));
        parkingService.parking(new ParkingBoyId("parking-boy-001"), new LicensePlate("川A8810"));
        parkingService.parking(new ParkingBoyId("parking-boy-001"), new LicensePlate("川A8811"));

        System.out.println(parkingRepo.find(new ParkingBoyId("parking-boy-001")));
    }
}
