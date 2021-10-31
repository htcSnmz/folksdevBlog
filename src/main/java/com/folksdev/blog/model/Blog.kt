package com.folksdev.blog.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Blog @JvmOverloads constructor(
        @Id
        @Column(name = "blog_id")
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = "",
        val title: String,
        val contents: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "writer_id", referencedColumnName = "writer_id")
        val writer: Writer
) {
}