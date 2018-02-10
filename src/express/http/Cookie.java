package express.http;


import java.time.Instant;

/**
 * @author Simon Reinisch
 */
public class Cookie {

  private String name, value;
  private String expire;
  private String path = "/";
  private String domain;
  private String sameSite;
  private boolean secure = false;
  private boolean httpOnly = false;
  private long maxAge = -1;

  /**
   * Creates an new http-cookie
   *
   * @param name  Cookie name
   * @param value Cookie value
   */
  public Cookie(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * @return The name of the Cookie
   */
  public String getName() {
    return name;
  }

  /**
   * Set the cookie name
   *
   * @param name The name
   * @return this cookie instance
   */
  public Cookie setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * @return The cookie value
   */
  public String getValue() {
    return value;
  }

  /**
   * Set the cookie value
   *
   * @param value The value
   * @return this cookie instance
   */
  public Cookie setValue(String value) {
    this.value = value;
    return this;
  }

  /**
   * @return The expire time in GTM format
   */
  public String getExpire() {
    return expire;
  }

  /**
   * Set the cookie expire (GMT wherefore Instant)
   * Default is infinite
   *
   * @param instant The instant
   * @return this cookie instance
   */
  public Cookie setExpire(Instant instant) {
    this.expire = instant.toString();
    return this;
  }

  public String getPath() {
    return path;
  }

  /**
   * Set the cookie path, also where the cookie should be send to the server
   * Default is root (/)
   *
   * @param path The path
   * @return this cookie instance
   */
  public Cookie setPath(String path) {
    this.path = path;
    return this;
  }

  /**
   * @return If the cookie is secure (SSL Only)
   */
  public boolean isSecure() {
    return secure;
  }

  /**
   * Set the if the cookie should be only send via SSL
   * Default is false
   *
   * @param secure if you want the cookie to be secure
   * @return this cookie instance
   */
  public Cookie setSecure(boolean secure) {
    this.secure = secure;
    return this;
  }

  /**
   * @return If the cookie is HttpOnly
   */
  public boolean isHttpOnly() {
    return httpOnly;
  }

  /**
   * Set the if the cookie shouldn't accessible via JavaScript through the Document.cookie property
   * Default is false
   *
   * @param httpOnly if you want the cookie to be httpOnly
   * @return this cookie instance
   */
  public Cookie setHttpOnly(boolean httpOnly) {
    this.httpOnly = httpOnly;
    return this;
  }

  public String getSameSite() {
    return sameSite;
  }

  public Cookie setSameSite(SameSite sameSite) {
    if (sameSite == null) return this;
    this.sameSite = sameSite.name();
    return this;
  }

  /**
   * @return the maximum age of this cookie (in milliseconds)
   */
  public long getMaxAge() {
    return maxAge;
  }

  /**
   * Set the maximum age for this cookie in ms
   * Default is infinite
   *
   * @param maxAge the maxage in milliseconds
   * @return this cookie instance
   */
  public Cookie setMaxAge(long maxAge) {
    this.maxAge = maxAge;
    return this;
  }

  /**
   * @return current cookie domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Set the cookie domauin
   * Default is not defined
   *
   * @param domain The domain
   */
  public void setDomain(String domain) {
    this.domain = domain;
  }

  @Override
  public String toString() {
    StringBuffer b = new StringBuffer();
    b.append(name).append("=").append(value);

    if (path != null) b.append("; Path=").append(path);
    if (expire != null) b.append("; Expire=").append(expire);
    if (maxAge != -1) b.append("; Max-Age=").append(maxAge);

    if (domain != null) b.append("; Domain=").append(domain);
    if (sameSite != null) b.append("; SameSite=").append(sameSite);

    if (secure) b.append("; Secure");
    if (httpOnly) b.append("; HttpOnly");

    return b.toString();
  }
}
