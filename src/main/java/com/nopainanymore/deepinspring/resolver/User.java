package com.nopainanymore.deepinspring.resolver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * deep-in-spring: User
 *
 * @author NoPainAnymore
 * @date 2019-05-14 22:57
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String userId;

    private String userName;

}
