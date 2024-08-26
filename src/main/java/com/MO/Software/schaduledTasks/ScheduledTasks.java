package com.MO.Software.schaduledTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.MO.Software.offers.offerService.OfferServiceInterface;

@Service
public class ScheduledTasks {

	@Autowired
	private OfferServiceInterface offerServiceI;
	/*
	 * Seconds (0): The first field specifies the seconds (0–59). In this case, it's set to 0, meaning the task will start at the beginning of the minute.

Minutes (0): The second field specifies the minutes (0–59). Here, it's also set to 0, meaning the task will start at the beginning of the hour.

Hours (0): The third field specifies the hour of the day (0–23). It's set to 0, meaning the task will start at midnight.

Day of the Month (*): The fourth field specifies the day of the month (1–31). The * means "every day," so the task will run every day of the month.

Month (*): The fifth field specifies the month (1–12). The * means "every month," so the task will run every month of the year.

Day of the Week (?): The sixth field specifies the day of the week (0–7 for Sunday–Saturday, with both 0 and 7 representing Sunday). The ? is a special character used when you don't need to specify a value for this field (typically used when you want to specify either the day of the month or the day of the week, but not both).
	 */
	//@Scheduled(cron = "0 * * * * ?") // Runs every minute
    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
	public void handleExpiredOffers()
	{
		offerServiceI.handleExpiredOffers();
	}
}
