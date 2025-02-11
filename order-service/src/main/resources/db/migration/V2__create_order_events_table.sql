create sequence order_event_id_seq start with 1 increment by 50;


create table orders_events
(
    id                        bigint default nextval('order_event_id_seq') not null,
    order_number              text not null references,
    event_id                  text not null unique,
    event_type                text not null,
    payload                   text not null,
    created_at                timestamp,
    updated_at                timestamp,
    primary key (id)
);
