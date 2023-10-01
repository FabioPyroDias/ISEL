using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ShipController : MonoBehaviour
{
    [SerializeField] private float bounds;
    [SerializeField] private float movementSpeed;
    [SerializeField] private GameObject missilePrefab;

    [SerializeField] private float timeBetweenShoots;
    private bool canShoot;

    private float health;
    private Renderer rendererComponent;
    private bool canLoseHealth;

    private Color green;
    private Color yellow;
    private Color red;
    private Color purple;

    // Start is called before the first frame update
    void Start()
    {
        health = 2;
    
        green = new Color(0, 255, 0);
        yellow = new Color(255, 255, 0);
        red = new Color(255, 0, 0);
        purple = new Color(148, 0, 211);

        rendererComponent = GetComponent<Renderer>();
        rendererComponent.material.color = green;
        
        foreach (Transform component in transform)
        {
            component.GetComponent<Renderer>().material.color = green; 
        }

        canShoot = true;

        canLoseHealth = true;
    }

    // Update is called once per frame
    void Update()
    {
        Move();
        Shoot();
    }

    private void Move()
    {
        transform.position = new Vector3(Mathf.Clamp(transform.position.x + Input.GetAxisRaw("Horizontal") * movementSpeed * Time.deltaTime, -bounds, bounds), transform.position.y, transform.position.z);
    }

    private void Shoot()
    {
        if(Input.GetKey(KeyCode.W) && canShoot)
        {
            Instantiate(missilePrefab, transform.position + Vector3.forward, transform.rotation);
            StartCoroutine(CooldownShoot());
        }
    }

    private IEnumerator CooldownShoot()
    {
        canShoot = false;
        yield return new WaitForSeconds(timeBetweenShoots);
        canShoot = true;
    }

    private void OnCollisionEnter(Collision other) {
        Destroy(other.gameObject);
        
        if(canLoseHealth)
        {
            health--;

            if(health < 0)
            {
                Destroy(gameObject);
            }

            StartCoroutine(DamageCooldown());
        }
        
    }

    private IEnumerator ChangeColor(Color color)
    {
        rendererComponent.material.color = color;
        foreach (Transform component in transform)
        {
            component.GetComponent<Renderer>().material.color = color; 
        }

        yield return null;
    }

    private IEnumerator DamageCooldown()
    {
        canLoseHealth = false;
        StartCoroutine(ChangeColor(purple));
        yield return new WaitForSeconds(1);
        canLoseHealth = true;
        StartCoroutine(ChangeColor(SetColor()));
    }

    private Color SetColor()
    {
        if(health == 1)
        {
            return yellow;
        }
        else
        {
            return red;
        }
    }
}