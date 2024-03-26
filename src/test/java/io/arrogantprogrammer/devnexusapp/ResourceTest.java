package io.arrogantprogrammer.devnexusapp;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class ResourceTest {
    protected static final Logger LOGGER = getLogger(WhoIsTest.class);
    Long id;
    String name = "Barney";
    String charachter = "Yoda";
    String whoIs = """
            Yoda is a Jedi Master and one of the most powerful Jedi in the Star Wars universe.
            """;
    String poem = """
            In the heart of the Force, a wise soul dwells,
            Yoda, a master of tales he tells.
            With ears that listen to the galaxy's song,
            In his presence, we feel where we belong.
                        
            In a swampy domain, he makes his abode,
            A Jedi grandmaster, on the Force's road.
            His words are a beacon, shining bright,
            Guiding us through the darkest night.
                        
            "Size matters not," he gently imparts,
            "Judge me by my size, do you?" he starts.
            With a lightsaber and wisdom as his shield,
            In the Force's embrace, he is revealed.
                        
            Through trials and tests, he guides the way,
            Teaching us to learn, to grow, to stay.
            A mentor, a sage, in the Jedi's lore,
            Yoda's teachings echo forevermore.
                        
            In his eyes, a twinkle, a spark of mirth,
            A reminder that even in darkness, there's birth.
            With the Force as his ally, and truth as his light,
            Yoda's wisdom shines, ever bright.
            """;
    String updatedPoem = """
            In the heart of the Force, a wise soul dwells,
            Yoda, a master of tales he tells.
            With ears that listen to the galaxy's song,
            In his presence, we feel where we belong.
                        
            In a swampy domain, he makes his abode,
            A Jedi grandmaster, on the Force's road.
            His words are a beacon, shining bright,
            Guiding us through the darkest night.
                        
            "Size matters not," he gently imparts,
            "Judge me by my size, do you?" he starts.
            With a lightsaber and wisdom as his shield,
            In the Force's embrace, he is revealed.
                        
            Through trials and tests, he guides the way,
            Teaching us to learn, to grow, to stay.
            A mentor, a sage, in the Jedi's lore,
            Yoda's teachings echo forevermore.
                        
            In his eyes, a twinkle, a spark of mirth,
            A reminder that even in darkness, there's birth.
            With the Force as his ally, and truth as his light,
            Yoda's wisdom shines, ever bright.
                        
            On roller coasters of life, we rise and fall,
            Yet Yoda's wisdom stands tall.
            In the ups and downs of the Force's flow,
            His teachings guide us, help us grow.
            """;
}
