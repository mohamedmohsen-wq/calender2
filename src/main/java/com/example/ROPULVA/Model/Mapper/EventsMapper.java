package com.example.ROPULVA.Model.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.ROPULVA.Model.DTO.EventsRespoDTO;
import com.example.ROPULVA.Model.DTO.EventsSendDTO;
import com.example.ROPULVA.Model.DTO.EventsupdateDTO;
import com.example.ROPULVA.Model.Entity.EventsEntity;

@Mapper(componentModel = "spring")
public interface EventsMapper {
EventsEntity toEntity(EventsRespoDTO dto);
EventsRespoDTO dto (EventsEntity toEntity);


List<EventsEntity> listtoEntity(List<EventsRespoDTO> dto);
List<EventsRespoDTO> listdto (List<EventsEntity> toEntity);


EventsEntity toEntitysend (EventsSendDTO Send);
EventsSendDTO Send (EventsEntity toEntity);

EventsEntity toEntityupdate (EventsupdateDTO Send);
EventsupdateDTO update (EventsEntity toEntity);

}
