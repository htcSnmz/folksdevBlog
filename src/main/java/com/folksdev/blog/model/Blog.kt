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
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Blog

                if (id != null && id != other.id) return false
                if (title != other.title) return false
                if (contents != other.contents) return false
                if (writer != other.writer) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + title.hashCode()
                result = 31 * result + contents.hashCode()
                result = 31 * result + writer.id.hashCode()
                return result
        }
}