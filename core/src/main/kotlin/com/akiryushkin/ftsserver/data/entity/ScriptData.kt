package com.akiryushkin.ftsserver.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id
import javax.persistence.Table;

@Entity
@Table(name = "script_data")
class ScriptData {
    @Id
    @Column(name = "uuid")
    lateinit var uuid: String

    @Column(name = "data")
    lateinit var data: String
}
