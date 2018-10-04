package net.starkenberg.event.configuration;

import net.starkenberg.event.model.Event;
import net.starkenberg.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {

    @Autowired
    private EventRepository repository;

    public static final String CACHE_NAME = "event-cache";

    @Scheduled(cron = "6 11 */4 * * *")
    public void conditionallyReloadCache() {
        evictTheCache();
    }

    @CacheEvict(value = CACHE_NAME, allEntries = true)
    public void evictTheCache() {
        //Cache get evicted
        repository.findByActiveIsTrue();
    }

}
