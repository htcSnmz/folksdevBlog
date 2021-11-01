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
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Writer

                if (id != other.id) return false
                if (name != other.name) return false
                if (surname != other.surname) return false
                if (blogs != other.blogs) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + name.hashCode()
                result = 31 * result + surname.hashCode()
                result = 31 * result + (blogs?.hashCode() ?: 0)
                return result
        }
}