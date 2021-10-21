package com.folksdev.blog.dto

import javax.validation.constraints.*

data class CreateBlogRequest(

        @field:NotBlank
        val id: String,

        @field:NotBlank
        val writer: String,

        @field:NotBlank
        val title: String,

        @field:Size(message = "you must enter at least 100 characters", min = 100)
        val contents: String,

      ){
}