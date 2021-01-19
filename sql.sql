create table csse_covid_19_all_reports_daily_update
(
    id                  int auto_increment
        primary key,
    Province_State      varchar(50)  null,
    Country_Region      varchar(50)  not null,
    Last_Update         varchar(50)  not null,
    Confirmed           int          null,
    Deaths              int          null,
    Recovered           int          null,
    Active              int          null,
    Combined_Key        varchar(100) null,
    Incident_Rate       double       null,
    Case_Fatality_Ratio double       null
);
