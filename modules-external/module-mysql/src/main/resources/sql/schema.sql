-- define schema here

CREATE TABLE ForeCast (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    precipitationProbability TINYINT,
    precipitationType VARCHAR(255),
    amountOfPrecipitation VARCHAR(255),
    humidity TINYINT,
    amountOfSnow VARCHAR(255),
    skyStatus VARCHAR(255),
    temperature FLOAT,
    maxTemperatureOfDay FLOAT,
    minTemperatureOfDay FLOAT,
    horizontalWindSpeed FLOAT,
    verticalWindSpeed FLOAT,
    waveHeight FLOAT,
    windDirection SMALLINT,
    windSpeed FLOAT,
    forecastAt TIMESTAMP,
    announcedAt TIMESTAMP
);
