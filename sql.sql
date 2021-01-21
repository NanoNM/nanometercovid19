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

create table csse_covid_19_all_reports_hestory_daily_update
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

create table tencent_city_data
(
    Province_ID  int          not null,
    cityName     varchar(100) null,
    healRate     double       null,
    wzz          int          null,
    grade        varchar(100) null,
    heal         int          null,
    nowConfirm   int          null,
    dead         int          null,
    suspect      int          null,
    deadRate     int          null,
    todayConfirm int          null,
    confirm      int          null
);

create table tencent_city_his_data
(
    Province_ID  int          not null,
    cityName     varchar(100) null,
    healRate     double       null,
    wzz          int          null,
    grade        varchar(100) null,
    heal         int          null,
    nowConfirm   int          null,
    dead         int          null,
    suspect      int          null,
    deadRate     int          null,
    todayConfirm int          null,
    confirm      int          null
);

create table tencent_detailed_china_data
(
    id             int auto_increment
        primary key,
    province       varchar(100) not null,
    confirm        int          null,
    healRate       double       null,
    wzz            int          null,
    heal           int          null,
    nowConfirm     int          null,
    dead           int          null,
    suspect        int          null,
    deadRate       double       null,
    todayConfirm   int          null,
    wzz_add        int          null,
    lastUpdateTime varchar(100) null
);

create table tencent_detailed_china_his_data
(
    id             int auto_increment
        primary key,
    province       varchar(100) not null,
    confirm        int          null,
    healRate       double       null,
    wzz            int          null,
    heal           int          null,
    nowConfirm     int          null,
    dead           int          null,
    suspect        int          null,
    deadRate       double       null,
    todayConfirm   int          null,
    wzz_add        int          null,
    lastUpdateTime varchar(100) null
);

