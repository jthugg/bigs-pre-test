-- define schema here

CREATE TABLE ForeCast (
    id BIGINT PRIMARY KEY,
    precipitationProbability TINYINT,
    precipitationType VARCHAR(255),
    amountOfPrecipitation FLOAT,
    humidity TINYINT,
    amountOfSnow FLOAT,
    skyStatus VARCHAR(255),
    temperature SMALLINT,
    maxTemperatureOfDay SMALLINT,
    minTemperatureOfDay SMALLINT,
    horizontalWindSpeed FLOAT,
    verticalWindSpeed FLOAT,
    waveHeight FLOAT,
    windDirection SMALLINT,
    windSpeed FLOAT,
    forecastAt TIMESTAMP,
    announcedAt TIMESTAMP
);