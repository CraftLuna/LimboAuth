/*
 * Copyright (C) 2021 - 2025 Elytrium
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.elytrium.limboauth.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 2FA secrets stored in a separate, externally-managed table. The actual table name is
 * configurable via {@code DATABASE.TWO_FACTOR_TABLE}; the structure is fixed to
 * {@code accountID} (matches {@link RegisteredPlayer} id) and {@code secretKey}.
 */
@DatabaseTable
public class TwoFactorAuth {

  public static final String ACCOUNT_ID_FIELD = "accountID";
  public static final String SECRET_KEY_FIELD = "secretKey";

  @DatabaseField(id = true, columnName = ACCOUNT_ID_FIELD)
  private int accountId;

  @DatabaseField(columnName = SECRET_KEY_FIELD)
  private String secretKey = "";

  public TwoFactorAuth() {

  }

  public TwoFactorAuth(int accountId, String secretKey) {
    this.accountId = accountId;
    this.secretKey = secretKey;
  }

  public int getAccountId() {
    return this.accountId;
  }

  public TwoFactorAuth setAccountId(int accountId) {
    this.accountId = accountId;

    return this;
  }

  public String getSecretKey() {
    return this.secretKey == null ? "" : this.secretKey;
  }

  public TwoFactorAuth setSecretKey(String secretKey) {
    this.secretKey = secretKey;

    return this;
  }
}
