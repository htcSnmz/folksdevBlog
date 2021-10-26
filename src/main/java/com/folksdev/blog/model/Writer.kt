package com.folksdev.blog.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Writer @JvmOverloads constructor(
        @Id
        @Column(name = "writer_id")
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = "",
        val name: String,
        val surname: String,

        @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
        val blogs: Set<Blog>? = HashSet()
){
}